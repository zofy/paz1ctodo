package sk.upjs.ics.todo;

public enum UlohaDaOFactory {

    INSTANCE;

    public UlohaDao getUlohaDao() {
        String profil = System.getProperty("profil");
        return new mysqlUlohaDaO();
    }
}
