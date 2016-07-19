import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Diese Klasse implementiert das Interface VerleihService. Es handelt sich
 * lediglich um eine Dummy-Implementation, um die GUI zu testen.
 * 
 * @author GUI-Team
 * @version SoSe 2016
 */
class DummyVerleihService extends AbstractObservableService
        implements VerleihService
{
    // Generator für Zufallszahlen und zufällige boolsche Werte
    private static final Random RANDOM = new Random();

    private static final CD MEDIUM = new CD("Titel", "Kommentar", "Interpret",
            70);
    private static final Kundennummer KUNDENNUMMER = new Kundennummer(123456);
    private static final Kunde ENTLEIHER = new Kunde(KUNDENNUMMER, "Vorname",
            "Nachname");
    private static final Verleihkarte VERLEIHKARTE = new Verleihkarte(ENTLEIHER,
            MEDIUM, Datum.heute());

    public DummyVerleihService(KundenstammService kundenstamm,
            MedienbestandService medienbestand,
            List<Verleihkarte> initialBestand)
    {
    }

    /**
     * für jeden beliebigen Kunden wird ein Standardisiertes Medium anstelle der tatsächlich ausgeliehenen zurückgegeben.
     */
    @Override
    public List<Medium> getAusgelieheneMedienFuer(Kunde kunde)
    {
        List<Medium> ergebnisListe = new ArrayList<Medium>();
        ergebnisListe.add(MEDIUM);
        return ergebnisListe;
    }

    /**
     * gibt den standardisierten Entleiher ENTLEIHER zurück, an sich sollte der zu einem bestimmten Medium passende Entleiher zurückgegeben werden.
     */
    @Override
    public Kunde getEntleiherFuer(Medium medium)
    {
        return ENTLEIHER;
    }

    /**
     * gibt für jedes Medium die standartisierte Verleihkarte zurück.
     */
    @Override
    public Verleihkarte getVerleihkarteFuer(Medium medium)
    {
        return VERLEIHKARTE;
    }

    /**
     * gibt standardiesierte Liste zurück.
     */
    @Override
    public List<Verleihkarte> getVerleihkarten()
    {
        List<Verleihkarte> ergebnisListe = new ArrayList<Verleihkarte>();
        ergebnisListe.add(VERLEIHKARTE);
        return ergebnisListe;
    }

    /**
     * gibt einen zufälligen Rückgabewert, der Rückgabewert sollte sich danach richten, ob das Medium verliehen ist, oder nicht.
     */
    @Override
    public boolean istVerliehen(Medium medium)
    {
        return RANDOM.nextBoolean();
    }

    /**
     * noch nicht implementiert, soll ausgeliehene Medien zurücknehmen und die Verleihkarte löschen.
     */
    @Override
    public void nimmZurueck(List<Medium> medien, Datum rueckgabeDatum)
    {
    }

    /**
     * gibt einen zufälligen Rückgabewert, dieser sollte sich danach richten, ob ALLE Medien der Liste nicht ausgeliehen sind.
     */
    @Override
    public boolean sindAlleNichtVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }

    /**
     * gibt einen zufälligen Rückgabewert, dieser sollte sich danach richten, ob ALLE Medien der Liste ausgeliehen sind.
     */
    @Override
    public boolean sindAlleVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }

    /**
     * Ist noch nicht Implementiert
     */
    @Override
    public void verleiheAn(Kunde kunde, List<Medium> medien, Datum ausleihDatum)
    {
    }

    /**
     * prüft, ob der Standardentleiher der übergebene Entleiher ist.
     */
    @Override
    public boolean kundeImBestand(Kunde kunde)
    {
        return ENTLEIHER.equals(kunde);
    }

    /**
     * prüft, ob das Standardmedium das übergebene Medium ist.
     */
    @Override
    public boolean mediumImBestand(Medium medium)
    {
        return MEDIUM.equals(medium);
    }

    /**
     * sollte korrekt implementiert sein.
     */
    @Override
    public boolean medienImBestand(List<Medium> medien)
    {
        boolean result = true;
        for (Medium medium : medien)
        {
            if (!mediumImBestand(medium))
            {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * erstellt eine Liste, fügt die standartisierte Verleihkarte hinzu und gibt diese zurück. Für jeden Kunden geschieht das selbe.
     */
    @Override
    public List<Verleihkarte> getVerleihkartenFuer(Kunde kunde)
    {
        List<Verleihkarte> result = new ArrayList<Verleihkarte>();
        result.add(VERLEIHKARTE);
        return result;
    }

    /**
     * Verneint die Möglichkeit des Ausleihens, an sich sollte geprüft werden ob ein Medium ausleihbar ist oder nicht.
     */
    @Override
    public boolean istVerleihenMoeglich(Kunde kunde, List<Medium> medien)
    {
        return false;
    }
}
