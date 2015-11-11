package sk.upjs.ics.todo;

public enum UlohaDaOFactory {
    
    INSTANCE;
    
    public UlohaDao getUlohaDao() {
        String profil = System.getProperty("profil");
        if ("db".equals(profil)) {
            return new mysqlUlohaDaO();
        } else {
            return new PamatovyUlohaDao();
        }
    }
}
