let loginInput;
let passwordInput;
let showPasswordButton;

function init() {
    loginInput = document.getElementById('login');
    passwordInput = document.getElementById('password');
    showPasswordButton = document.getElementById('btn_show');
}

// Validar campos
function validarCampos(login, password) {
    if (login.trim() === '') {
        alert('Por favor, insira o email.');
        return false;
    }

    if (password.trim() === '') {
        alert('Por favor, insira a senha.');
        return false;
    }

    return true;
}

// Realizar o login
function loginUser() {
    if (!validarCampos(loginInput.value, passwordInput.value)) {
        return false;
    }

    if (loginInput.value === 'admin@email.com' && passwordInput.value === 'admin') {
        alert('Login efetuado com sucesso!');
        location.href = 'home.html';
    } else {
        alert('Usuário ou senha incorretos!');
    }

    return false;
}

// Ocultar ou mostrar o botão de mostrar senha
function showPassword() {
    if (passwordInput.value !== '') {
        showPasswordButton.style.display = 'block';
        showPasswordButton.addEventListener('click', toggle);
    } else {
        showPasswordButton.style.display = 'none';
    }
}

let active = false;

// Ocultar e mostar a senha
function toggle() {
    if (active) {
        passwordInput.setAttribute('type', 'password');
        active = false;
        showPasswordButton.innerHTML = '<i class="fas fa-eye"></i>';
    } else {
        passwordInput.setAttribute('type', 'text');
        active = true;
        showPasswordButton.innerHTML = '<i class="fas fa-eye-slash"></i>';
    }
}

// Inicializar as variáveis globais
window.onload = function () {
    init();
    passwordInput.addEventListener('input', showPassword);
};
