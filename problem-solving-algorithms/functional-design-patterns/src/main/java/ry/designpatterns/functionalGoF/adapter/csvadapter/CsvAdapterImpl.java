package ry.designpatterns.functionalGoF.adapter.csvadapter;

import ry.designpatterns.functionalGoF.adapter.adaptee.CsvFormattable;
import ry.designpatterns.functionalGoF.adapter.source.TextFormattable;

public class CsvAdapterImpl implements TextFormattable {
    CsvFormattable csvFormatter;
    public CsvAdapterImpl(CsvFormattable csvFormatter){
        this.csvFormatter=csvFormatter;
    }
    @Override
    public String formatText(String text)
    {
        String formattedText=csvFormatter.formatCsvText(text);
        return formattedText;
    }
}
