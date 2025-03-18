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

// Validar login antes de enviar
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

// Definir alarme
document.addEventListener("DOMContentLoaded", function() {
    let alarmeForm = document.getElementById("alarmeForm");
    if (alarmeForm) {
        alarmeForm.addEventListener("submit", function(event) {
            let horario = document.getElementById("horario").value;
            if (!horario) {
                event.preventDefault();
                exibirMensagem("erro", "Escolha um horário para o alarme!");
            } else {
                exibirMensagem("sucesso", "Alarme definido com sucesso!");
            }
        });
    }
});

// Enviar resposta do quiz
document.addEventListener("DOMContentLoaded", function() {
    let quizForm = document.getElementById("quizForm");
    if (quizForm) {
        quizForm.addEventListener("submit", function(event) {
            let respostaSelecionada = document.querySelector("input[name='resposta']:checked");
            if (!respostaSelecionada) {
                event.preventDefault();
                exibirMensagem("erro", "Escolha uma resposta!");
            }
        });
    }
});