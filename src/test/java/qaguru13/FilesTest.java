package qaguru13;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;


public class FilesTest {
  ClassLoader cl = FilesTest.class.getClassLoader();
    @Test
    void pdfParseTest() throws Exception {
      try (InputStream resourceAsStream = cl.getResourceAsStream("COMP3710Outline.pdf")) {
        PDF content = new PDF(resourceAsStream);
        assertThat(content.text).contains("Manage Project");
      }
    }

  @Test
  void xlsParseTest() throws Exception {
    try (InputStream resourceAsStream = cl.getResourceAsStream("ИПР.xlsx")) {
      XLS content = new XLS(resourceAsStream);
      assertThat(content.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue()).contains("Сроки");
    }
  }

  @Test
  void csvParseTest() throws Exception {
    try (
            InputStream resource = cl.getResourceAsStream("Sample.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(resource));
    ) {
      List<String[]> content = reader.readAll();
      assertThat(content.get(0)[1]).contains("Speaker");
    }
  }

  @Test
  void zipParseTest() throws Exception {
    try (
            InputStream resource = cl.getResourceAsStream("Архив.zip");
            ZipInputStream zis = new ZipInputStream(resource)
    ) {
      ZipEntry entry;
      while((entry = zis.getNextEntry()) != null) {
        assertThat(entry.getName()).containsAnyOf("COMP3710Outline.pdf", "Sample.csv", "ИПР.xlsx");
          switch (entry.getName()){
            case "COMP3710Outline.pdf":
              PDF contentPdf = new PDF(zis);
              assertThat(contentPdf.text).contains("Manage Project");
              break;
            case "ИПР.xlsx":
              XLS contentXls = new XLS(zis);
              assertThat(contentXls.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue()).contains("Сроки");
              break;
            case "Sample.csv":
                CSVReader reader = new CSVReader(new InputStreamReader(zis));
                List<String[]> content = reader.readAll();
                assertThat(content.get(0)[1]).contains("Speaker");
              break;
          }
      }
    }
  }
}

