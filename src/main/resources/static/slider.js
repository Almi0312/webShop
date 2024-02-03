$(document).ready(function() {
    $(".slider").each(function() {
        var slides = $(this).find(".slides img");
        var slideCount = slides.length;
        var slideWidth = slides.first().width();
        var currentIndex = 0;

        function goToSlide(index) {
            if (index < 0 || index >= slideCount) {
                return;
            }
            $(this).find(".slides").css("transform", "translateX(-" + (slideWidth * index) + "px)");
            currentIndex = index;
        }

        function nextSlide() {
            goToSlide(currentIndex + 1);
        }

        function prevSlide() {
            goToSlide(currentIndex - 1);
        }

        $(this).find(".next").on("click", function() {
            nextSlide();
        });

        $(this).find(".prev").on("click", function() {
            prevSlide();
        });
    });
});