// Получаем все слайдеры на странице
var sliders = document.querySelectorAll('.slider');

// Для каждого слайдера
sliders.forEach(function(slider) {
  // Получаем кнопки "Previous" и "Next"
  var prevButton = slider.querySelector('.prev');
  var nextButton = slider.querySelector('.next');

  // Получаем все слайды внутри текущего слайдера
  var slides = slider.querySelector('.slides');

  // Получаем ширину слайдера
  var sliderWidth = slider.offsetWidth;

  // Получаем количество слайдов
  var slideCount = slides.children.length;

  // Устанавливаем текущий индекс слайда
  var currentIndex = 0;

  // Обработчик клика на кнопку "Previous"
  prevButton.addEventListener('click', function() {
    // Уменьшаем индекс текущего слайда
    currentIndex--;

    // Если индекс становится меньше 0, переходим к последнему слайду
    if (currentIndex < 0) {
      currentIndex = slideCount - 1;
    }

    // Перемещаем слайды влево на ширину слайдера, умноженную на текущий индекс
    slides.style.transform = 'translateX(' + (-sliderWidth * currentIndex) + 'px)';
  });

  // Обработчик клика на кнопку "Next"
  nextButton.addEventListener('click', function() {
    // Увеличиваем индекс текущего слайда
    currentIndex++;

    // Если индекс становится больше или равен количеству слайдов, переходим к первому слайду
    if (currentIndex >= slideCount) {
      currentIndex = 0;
    }

    // Перемещаем слайды влево на ширину слайдера, умноженную на текущий индекс
    slides.style.transform = 'translateX(' + (-sliderWidth * currentIndex) + 'px)';
  });
});
