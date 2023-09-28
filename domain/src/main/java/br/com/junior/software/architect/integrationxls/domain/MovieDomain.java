package br.com.junior.software.architect.integrationxls.domain;

import br.com.junior.software.architect.integrationxls.core.XlsReadException;
import br.com.junior.software.architect.integrationxls.properties.XlsProperties;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MovieDomain implements MovieFacade {

    private final MovieRepository repository;
    private final XlsProperties xlsProperties;


    /**
     * Generate entity movies in xlsx format from disk or properties configuration
     */
    public void generateEntityMovieByXlsFile(){
        final var workbook = getWorkbook();
        final var sheet = workbook.getSheetAt(0);

        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {

                }
            }
            i++;
        }
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
