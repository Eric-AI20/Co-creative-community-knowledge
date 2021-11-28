$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

    $('#communityList').on('click', function () {
        $('#communitySubmenu').collapse('toggle');
    });

    $('#resourcesList').on('click', function () {
        $('#resourcesSubMenu').collapse('toggle');
    });

    $('#trainingList').on('click', function () {
        $('#trainingSubMenu').collapse('toggle');
    });

});

window.onscroll = function () {
    myFunction()
};

var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
    if (window.pageYOffset >= sticky) {
        navbar.classList.add("sticky")
    } else {
        navbar.classList.remove("sticky");
    }
}