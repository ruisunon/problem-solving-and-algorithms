package ry.designpatterns.functionalGoF.adapter.source;

import ry.designpatterns.functionalGoF.adapter.adaptee.CsvFormattable;
import ry.designpatterns.functionalGoF.adapter.adaptee.CsvFormatter;
import ry.designpatterns.functionalGoF.adapter.csvadapter.CsvAdapterImpl;
import org.junit.Test;

import static org.junit.Assert.*;


public class NewLineFormatterTest {
    @Test
    public void testFormatText() throws Exception {

            String testString=" Formatting line 1. Formatting line 2. Formatting line 3.";
            TextFormattable newLineFormatter=new NewLineFormatter();
            String resultString = newLineFormatter.formatText(testString);
            System.out.println(resultString);

            CsvFormattable csvFormatter=new CsvFormatter();
            TextFormattable csvAdapter=new CsvAdapterImpl(csvFormatter);
            String resultCsvString=csvAdapter.formatText(testString);
            System.out.println(resultCsvString);
    }
}