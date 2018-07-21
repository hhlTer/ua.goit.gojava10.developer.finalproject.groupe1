// Tabs
function openLink(evt, linkName) {
    var i, x, tablinks;
    x = document.getElementsByClassName("myLink");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < x.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
    }
    document.getElementById(linkName).style.display = "block";
    evt.currentTarget.className += " w3-red";
}

function ComboBoxDate() {
    Day();
    Mounth();
    Year();
}
function Mounth() {
    var select = document.getElementById("selectMounth");
    var options = [
    "January", "February", "March", "April",  "May",
    "June",  "July",  "August",  "September",  "October",
    "November",  "December"];

    // Optional: Clear all existing options first:
    select.innerHTML = "";
    // Populate list with options:
    for (var i = 0; i < options.length; i++) {
        var opt = options[i];
        select.innerHTML += "<option value=\"" + opt + "\">" + opt + "</option>";
    }
    select.options[0].selected = 'selected';
}

function Day() {
    var select = document.getElementById("selectDay");
    // Optional: Clear all existing options first:
    select.innerHTML = "";
    // Populate list with options:
    for (var i = 1; i <= 31; i++) {
        var opt = i;
        select.innerHTML += "<option value=\"" + opt + "\">" + opt + "</option>";
    }
    select.options[0].selected = 'selected';
}

function Year() {
    var select = document.getElementById("selectYear");
    // Optional: Clear all existing options first:
    select.innerHTML = "";
    // Populate list with options:
    for (var i = 1900; i < 2050; i++) {
        var opt = i;
        select.innerHTML += "<option value=\"" + opt + "\">" + opt + "</option>";
    }
    select.options[100].selected = 'selected';
}

