// Exibir mensagens de erro e sucesso
function exibirMensagem(tipo, mensagem) {
    let alerta = document.createElement("div");
    alerta.textContent = mensagem;
    alerta.style.padding = "10px";
    alerta.style.margin = "10px 0";
    alerta.style.borderRadius = "5px";

    if (tipo === "erro") {
        alerta.style.backgroundColor = "#e57373";
        alerta.style.color = "#fff";
    } else {
        alerta.style.backgroundColor = "#81c784";
        alerta.style.color = "#fff";
    }

    document.body.prepend(alerta);
    setTimeout(() => alerta.remove(), 3000);
}

// Validação do formulário de login
document.addEventListener("DOMContentLoaded", function() {
    let loginForm = document.getElementById("loginForm");
    if (loginForm) {
        loginForm.addEventListener("submit", function(event) {
            let email = document.getElementById("email").value;
            let senha = document.getElementById("senha").value;

            if (!email || !senha) {
                event.preventDefault();
                exibirMensagem("erro", "Preencha todos os campos!");
            }
        });
    }
});