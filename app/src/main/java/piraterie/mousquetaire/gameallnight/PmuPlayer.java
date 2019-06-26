package piraterie.mousquetaire.gameallnight;

public class PmuPlayer {
    private int id;
    private String name;
    private int ngGorgees;
    private int type;

    public PmuPlayer() {
        this.id =0;
        this.name = "name";
        this.ngGorgees = 0;
        this.type = 0;
    }

    public PmuPlayer(int id, String name, int ngGorgees, int type) {
        this.id = id;
        this.name = name;
        this.ngGorgees = ngGorgees;
        this.type = ( type < 1 || type > 4 ? 0 : type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNgGorgees() {
        return ngGorgees;
    }

    public void setNgGorgees(int ngGorgees) {
        this.ngGorgees = ngGorgees;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
