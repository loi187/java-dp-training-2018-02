package adapter;

public class HtmlRenderer {

    public String render(TableModel tableModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>");

        sb.append("<tr>");
        for (Column column: tableModel.getColumns()) {
            sb.append("<th>").append(column.getName()).append("</th>");
        }
        sb.append("</tr>");

        for (int row = 0; row < tableModel.getRowCount(); row++) {
            sb.append("<tr>");
            for (Column column: tableModel.getColumns()) {
                sb.append("<td>").append(tableModel.getValueAt(row, column)).append("</td>");
            }
            sb.append("</tr>");
        }
        return sb.toString();
    }
}
