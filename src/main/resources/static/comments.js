const commentInput = document.querySelector('.comment-input textarea');
const addCommentButton = document.querySelector('.comment-input button');
const commentsContainer = document.querySelector('.comments');

// Обработчик события для кнопки добавления комментария
addCommentButton.addEventListener('click', () => {
    const commentText = commentInput.value.trim();
    if (commentText !== '') {
        // Отправка комментария на сервер (здесь можно использовать AJAX или Fetch API)
        // Пример AJAX запроса с использованием jQuery:
        /*
        $.ajax({
            type: 'POST',
            url: '/add-comment',
            data: { comment: commentText },
            success: function(response) {
                // Обработка успешного ответа сервера
                // Например, обновление списка комментариев
                const newComment = document.createElement('div');
                newComment.textContent = commentText;
                commentsContainer.appendChild(newComment);
                commentInput.value = '';
            },
            error: function(error) {
                // Обработка ошибки
            }
        });
        */

        // Пример добавления комментария без отправки на сервер (только для демонстрации)
        const newComment = document.createElement('div');
        newComment.textContent = commentText;
        commentsContainer.appendChild(newComment);
        commentInput.value = '';
    }
});