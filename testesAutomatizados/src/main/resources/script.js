document.getElementById("enviarBtn").onclick = function(event) {
    event.preventDefault();
  
    // Enviar dados
    sendData();
  
    // Limpar campos
    clearFields();
  
    // Exibir mensagem de sucesso
    showSuccessMessage();
  };
  
  function sendData() {
    // Aqui você pode adicionar lógica para enviar os dados para um servidor
    // ou realizar outras ações necessárias com os dados do formulário
  }
  
  function clearFields() {
    document.getElementById("myForm").reset();
  }
  
  function showSuccessMessage() {
    var successMessage = document.getElementById("successMessage");
    successMessage.classList.remove("hidden");
  }
  