/**
 * Created by Metr_yumora on 18.05.2017.
 */

function redirectTo(id) {
    var e = document.getElementById(id);
    var link = e.options[e.selectedIndex].value;
    window.location.replace(link)
}
