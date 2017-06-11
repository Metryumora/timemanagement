/**
 * Created by Metr_yumora on 31.05.2017.
 */

function submitForm(num) {
    var form = document.forms["formSelectors"];
    switch (num) {
        case 1: {
            form.action = "/departments";
            break
        }
        case 2: {
            form.action = "/specialists";
            break
        }
        case 3: {
            form.action = "/appointments";
            break
        }
        case 4: {
            form.action = "/arrange";
            break
        }
    }
    form.submit()
}