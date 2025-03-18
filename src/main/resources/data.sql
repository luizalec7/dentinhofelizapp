-- Inserção de usuários
INSERT INTO usuario (email, senha) VALUES ('usuario1@gmail.com', 'senha123');
INSERT INTO usuario (email, senha) VALUES ('usuario2@gmail.com', 'senha456');

-- Inserção de dúvidas
INSERT INTO duvida (pergunta, resposta) VALUES ('Quantas vezes devo escovar os dentes por dia?', 'O ideal é escovar os dentes pelo menos 3 vezes ao dia.');
INSERT INTO duvida (pergunta, resposta) VALUES ('O que é cárie?', 'Cárie é uma deterioração do dente causada por bactérias e açúcares.');

-- Inserção de alarmes
INSERT INTO alarme (horario) VALUES ('07:00 AM');
INSERT INTO alarme (horario) VALUES ('12:00 PM');
INSERT INTO alarme (horario) VALUES ('20:30 PM');

-- Inserção de quizzes
INSERT INTO quiz (pergunta, resposta_correta) VALUES ('Qual a principal função do fio dental?', 'Remover restos de alimentos');
INSERT INTO quiz (pergunta, resposta_correta) VALUES ('Quantos dentes permanentes um adulto tem?', '32');

-- Inserção de opções de quiz (para simular a lista de respostas possíveis)
INSERT INTO quiz_opcoes (quiz_id, opcoes) VALUES (1, 'Branquear os dentes');
INSERT INTO quiz_opcoes (quiz_id, opcoes) VALUES (1, 'Remover restos de alimentos');
INSERT INTO quiz_opcoes (quiz_id, opcoes) VALUES (1, 'Substituir a escovação');
INSERT INTO quiz_opcoes (quiz_id, opcoes) VALUES (1, 'Limpar a língua');

INSERT INTO quiz_opcoes (quiz_id, opcoes) VALUES (2, '28');
INSERT INTO quiz_opcoes (quiz_id, opcoes) VALUES (2, '32');
INSERT INTO quiz_opcoes (quiz_id, opcoes) VALUES (2, '36');
INSERT INTO quiz_opcoes (quiz_id, opcoes) VALUES (2, '40');

-- Inserção de pontuação inicial
INSERT INTO pontuacao (usuario_id, pontos) VALUES (1, 10);
INSERT INTO pontuacao (usuario_id, pontos) VALUES (2, 20);

-- Inserção de premiações
INSERT INTO premiacao (descricao, pontos_necessarios) VALUES ('Medalha de Higiene Bucal', 50);
INSERT INTO premiacao (descricao, pontos_necessarios) VALUES ('Troféu Dentinho de Ouro', 100);