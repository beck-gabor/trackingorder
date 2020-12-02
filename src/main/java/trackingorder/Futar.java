package trackingorder;
/*
A vevő online rendelés esetén, amennyiben házhoz szállítást kért, miután a futár átvette
a rendelt termékeket a rendelés azonnal
IN_PROGRESS státuszba kell kerüljön
Amennyiben a házhozszállítás megtörténik, a rendelés
DELIVERED státuszba kell kerüljön
Amennyiben nem sikerül a házhozszállítás, a rendelés
FAILED_DELIVERY státuszba kell kerüljön és a futárnak lehetőséget kell adni (kötelezően), hogy kommentet fűzhessen a rendeléshez a sikertelenség okáról. (nem vették át, nem voltak otthon...)
*/
public class Futar {

    public void sikeresKiszallitas( Order order ){

    }

    public void sikertelenKiszallitas( Order order , String uzenet ){

    }

}
