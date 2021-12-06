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

    $('#commentbutton').on('click', function () {
        $('.commentSection').show()
    });
});
var num = 1;

$(window).bind('scroll', function () {
    if ($(window).scrollTop() > num) {
        $('.navbar').addClass('sticky');
    } else {
        $('.navbar').removeClass('sticky');
    }
});

// function showPostBody(x) {
//     console.log("focus");
// }

// $("#form_task_comment").on("change, blur", function () {
//     $(".buttons").hide(); //hide when user moves focus out of the textarea
// });


