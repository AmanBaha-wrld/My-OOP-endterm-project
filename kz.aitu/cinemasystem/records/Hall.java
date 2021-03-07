package kz.aitu.cinemasystem.records;

public class Hall {
    private int hall_id;
    private int rows;
    private int columns;
    public Hall(){

    }
    public Hall(int rows, int columns){
        setColumns(rows);
        setRows(columns);
    }
    public Hall(int hall_id, int rows, int columns){
        setHall_id(hall_id);
        setRows(rows);
        setColumns(columns);
    }

    public void setHall_id(int hall_id){this.hall_id = hall_id;}
    public void setRows(int rows){this.rows = rows;}
    public void setColumns(int columns){this.columns=columns;}

    public int getCinema_id() {
        return hall_id;
    }
    public int getRows(){return  rows;}
    public int getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        return "Hall: {" +
                "Hall ID = " + hall_id + "\n" +
                "Rows = '" + rows + "'\n" +
                "Columns = '" + columns + "'\n" +
                "}";
    }
}
