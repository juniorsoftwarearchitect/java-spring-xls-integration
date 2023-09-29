package br.com.junior.software.architect.integrationxls.domain;

import br.com.junior.software.architect.integrationxls.core.XlsReadException;
import br.com.junior.software.architect.integrationxls.entity.Movie;
import br.com.junior.software.architect.integrationxls.properties.XlsProperties;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieIntegration {
    private final MovieRepository repository;
    private final XlsProperties xlsProperties;

    @PostConstruct
    public void init() {
        generateEntityMovieByXlsFile();
    }

    /**
     * Generate entity movies in xlsx format from disk or properties configuration
     */
    @Transactional
    public void generateEntityMovieByXlsFile(){
        final var workbook = getWorkbook();
        final var sheet = workbook.getSheetAt(0);
        final var movies = generateEntityMovieDTO(sheet);
        repository.saveAll(movies);

    }

    private List<Movie> generateEntityMovieDTO(XSSFSheet sheet) {
        final var xlsxList = generateEntityMovieInFileXlsxPoorlyDone(sheet);
        return xlsxList.stream().map(xlsx -> {
            final String[] column = xlsx.split(";");
            final boolean winner = column.length >= 5 && "yes".equals(column[4]) ? Boolean.TRUE : Boolean.FALSE;
            return new Movie()
                    .setMovieYear(Integer.valueOf(column[0]))
                    .setTitle(column[1])
                    .setStudios(column[2])
                    .setProducer(column[3])
                    .setWinner(winner);

        }).collect(Collectors.toList());
    }


    private List<String> generateEntityMovieInFileXlsxPoorlyDone(final XSSFSheet sheet) {
        final var listRow = new ArrayList<String>();
        for (final Row row : sheet) {
            if (row.getRowNum() != 0) {
                String cellValue = "";
                for (final Cell cell : row) {
                    if (!ObjectUtils.isEmpty(cell.getStringCellValue())) {
                        cellValue += cell.getStringCellValue();
                        cellValue = cellValue.substring(cellValue.length() - 1).equals(";") ? cellValue : String.format("%s;", cellValue);
                    }
                }
                if (!ObjectUtils.isEmpty(cellValue))
                    listRow.add(cellValue);
            }
        }
        return listRow;

    }



    /**
     * Get workbook xlsx format from disk or properties configuration
     * @return {@link XSSFWorkbook}
     */
    private XSSFWorkbook getWorkbook() {

        try {
            InputStream file;
            if (Objects.isNull(xlsProperties.getIntegration())) {
                file = this.getClass().getClassLoader()
                        .getResourceAsStream("movielist.xlsx");
            } else {
                file = new FileInputStream(new File(xlsProperties.getIntegration()));
            }
            return new XSSFWorkbook(file);
        } catch (IOException exception) {
            throw new XlsReadException(exception);
        }

    }


}
