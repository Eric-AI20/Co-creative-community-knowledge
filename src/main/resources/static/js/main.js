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


