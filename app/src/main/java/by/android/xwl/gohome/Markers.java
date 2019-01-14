package by.android.xwl.gohome;

import java.lang.reflect.Type;

enum TypeMarkers{
    type1,
    type2
}

enum PriorityMarkers{
    Easy,
    Normal,
    High
}

public class Markers {
    private TypeMarkers type;
    //TODO: Change coordinate system!
    private double posX;
    private double posY;
    private PriorityMarkers priority;
    private String info;

    public String toStrring(){
        return "Type: " + type + " ("+posX+","+posY+") Priority: "
                + priority + " Info: " + info;
    }


    public TypeMarkers getType() {
        return type;
    }

    public void setType(TypeMarkers type) {
        this.type = type;
    }

    public void setType(String type) {
        if("type1".equalsIgnoreCase(type)){
            this.type = TypeMarkers.type1;
        } else if ("type2".equalsIgnoreCase(type)){
            this.type = TypeMarkers.type2;
        }
    }

    public PriorityMarkers getPriority() {
        return priority;
    }

    public void setPriority(PriorityMarkers priority) {
        this.priority = priority;
    }

    public void setPriority(String priority) {
        if ("easy".equalsIgnoreCase(priority)){
            this.priority = PriorityMarkers.Easy;
        } else if ("normal".equalsIgnoreCase(priority)){
            this.priority = PriorityMarkers.Normal;
        } else if ("High".equalsIgnoreCase(priority)){
            this.priority = PriorityMarkers.High;
        }
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
}
