document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('enviar').addEventListener('click', function () {
      // Obtém o valor do campo de feedback
      var feedbackValue = document.getElementById('feedback').value;

      // Verifica se o campo de feedback não está vazio
      if (feedbackValue.trim() !== '') {
        // Exibe a mensagem de feedback enviado com sucesso
        alert('Feedback enviado com sucesso');
      } else {
        // Caso contrário, exibe uma mensagem de erro
        alert('Por favor, preencha o campo de feedback antes de enviar.');
      }
    });
  });