package adapter;

import java.util.List;

public interface TableModel {

    int getRowCount();

    List<Column> getColumns();

    String getValueAt(int row, Column column);

}
