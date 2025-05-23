
# 📱 Dentinho Feliz

Aplicativo mobile educativo para crianças até 14 anos com foco em higiene bucal, desenvolvido em React Native utilizando Expo Router. O app oferece quizzes, dúvidas frequentes, alarmes de escovação e sistema de gamificação com mascote infantil.

---

## 👨‍👩‍👦‍👦 Integrantes do Grupo

- Luiz Alecsander Viana - RM553034
- Guilherme Augusto de Oliveira - RM554176
- Lucas Martinez Lopes - RM553816

---

## 🎯 Objetivo

O **Dentinho Feliz** visa estimular hábitos saudáveis de higiene bucal em crianças de forma lúdica e interativa, contribuindo para a prevenção de doenças bucais e redução da necessidade de tratamentos odontológicos.

---

## 🧩 Funcionalidades

- ✅ Cadastro e Login com persistência de dados (AsyncStorage)
- 🧠 Quiz interativo com perguntas de múltipla escolha
- 🛎️ Alarmes para lembrar de escovar os dentes
- ❓ Tela de dúvidas frequentes com possibilidade de administração
- 👤 Perfil do usuário com imagem e informações
- 🦷 Mascote infantil para engajar o público
- 🧪 Testes de funcionalidades e navegação entre telas
- 🌐 Integração com APIs hospedadas no Render

---

## ⚙️ Tecnologias Utilizadas

- **React Native**
- **Expo Router**
- **TypeScript**
- **AsyncStorage**
- **Axios**
- **React Navigation**
- **API Restful (Render + JSON Server)**

---

## 🔗 APIs Utilizadas

- Quizzes: [https://api-quiz-6a27.onrender.com](https://api-quiz-6a27.onrender.com)
- Dúvidas: [https://api-higiene-bucal-2.onrender.com](https://api-higiene-bucal-2.onrender.com)

---

## 📱 Telas Implementadas

- `LoginScreen` – Tela de autenticação
- `RegisterScreen` – Cadastro de novos usuários
- `HomeScreen` – Tela principal com navegação entre funcionalidades
- `QuizScreen` – Exibição sequencial de perguntas com cálculo de pontuação
- `HelpScreen` – Lista de dúvidas frequentes, opção de adicionar dúvida
- `AlarmScreen` – Cadastro, edição e remoção de alarmes com data e hora
- `ProfileScreen` – Exibição da imagem de perfil, email e botão de alterar senha
- `AdminDoubtScreen` – Tela de administração de dúvidas com CRUD completo

---

## 📁 Estrutura do Projeto

```bash
dentinhofeliz/
├── assets/
│   └── imagens/         # Imagens, ícones, mascote
├── components/          # Componentes reutilizáveis (botões, cards)
├── screens/             # Telas principais do aplicativo
│   ├── HomeScreen.tsx
│   ├── LoginScreen.tsx
│   ├── RegisterScreen.tsx
│   ├── QuizScreen.tsx
│   ├── HelpScreen.tsx
│   ├── AlarmScreen.tsx
│   ├── ProfileScreen.tsx
│   └── AdminDoubtScreen.tsx
├── services/            # Integração com APIs
│   ├── apiQuiz.ts
│   └── apiDoubt.ts
├── utils/               # Utilitários como AsyncStorage
│   └── AsyncStorageUtils.ts
├── App.tsx              # Componente principal
└── README.md
```

---

## 🎥 Demonstração

> Incluído vídeo demonstrando a navegação entre telas, uso do quiz, alarmes e tela de dúvidas.

---

## 📌 Observações

- Todas as informações são salvas localmente com `AsyncStorage`.
- APIs hospedadas no Render com JSON Server simulando backend.
- Projeto atende aos critérios da Sprint 4 de Mobile App Development.

---