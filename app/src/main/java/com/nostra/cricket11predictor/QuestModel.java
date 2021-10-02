package com.nostra.cricket11predictor;

public class QuestModel {
    private String Postedon,Venue,Pitchreport,Favourites,Dreamteam,Notes;
    public QuestModel() {

    }
    public QuestModel(String postedon,String venue,String pitchreport,String favourites,String dreamteam,String notes) {
        Postedon=postedon;
        Venue=venue;
        Pitchreport=pitchreport;
        Favourites=favourites;
        Dreamteam=dreamteam;
        Notes=notes;

    }

    public String getPostedon() { return Postedon; }

    public void setPostedon(String postedon) { Postedon = postedon; }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) { Venue = venue; }

    public String getPitchreport() {
        return Pitchreport;
    }

    public void setPitchreport(String pitchreport) { Pitchreport = pitchreport; }

    public String getFavourites() { return Favourites; }

    public void setFavourites(String favourites) { Favourites = favourites; }

    public String getDreamteam() {
        return Dreamteam;
    }

    public void setDreamteam(String dreamteam) { Dreamteam = dreamteam; }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) { Notes = notes; }


}
