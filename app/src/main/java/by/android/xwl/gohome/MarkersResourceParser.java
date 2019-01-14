package by.android.xwl.gohome;


import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class MarkersResourceParser {
    private ArrayList<Markers> markers;
    public MarkersResourceParser(){
        markers = new ArrayList<>();
    }

    public ArrayList<Markers> getMarkers(){
        return markers;
    }

    public boolean parse(XmlPullParser xpp){
        boolean status = true;
        Markers currentMarkers = null;
        boolean isEntry = false;
        String textValue = "";
        try{
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if ("markers".equalsIgnoreCase(tagName)){
                            isEntry = true;
                            currentMarkers = new Markers();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(isEntry){
                            if("markers".equalsIgnoreCase(tagName)){
                                markers.add(currentMarkers);
                                isEntry = false;
                            } else if ("type".equalsIgnoreCase(tagName)){
                                currentMarkers.setType(textValue);
                            } else if ("posX".equalsIgnoreCase(tagName)){
                                currentMarkers.setPosX(Double.valueOf(textValue));
                            } else if ("posY".equalsIgnoreCase(tagName)){
                                currentMarkers.setPosY(Double.valueOf(textValue));
                            } else if ("priority".equalsIgnoreCase(tagName)){
                                currentMarkers.setPriority(textValue);
                            } else if ("info".equalsIgnoreCase(tagName)){
                                currentMarkers.setInfo(textValue);
                            }
                        }
                        break;
                    default: break;
                }
                eventType = xpp.next();
            }
        } catch (Exception e){
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}
