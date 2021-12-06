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

$(document).ready(function () {
    $("#createPost").focus(function () {
        console.log("Focus")
        $(".postbody").show(); //show when user moves focus in the textarea
    });
});

// function showPostBody(x) {
//     console.log("focus");
// }

// $("#form_task_comment").on("change, blur", function () {
//     $(".buttons").hide(); //hide when user moves focus out of the textarea
// });


