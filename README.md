1)Explique detalhadamente como o gerenciamento de ciclo de vida de uma Activity impacta a performance e 
o gerenciamento de memória em um aplicativo Android, especialmente em cenários de múltiplas Activitys e 
rotacionamento de tela. Como os métodos onSaveInstanceState() e onRestoreInstanceState() podem ser usados 
para garantir que dados cruciais não sejam perdidos, e como isso se relaciona com o conceito de "State Restoration" em sistemas móveis?

O ciclo de vida de uma Activity consiste em gerenciar a atividade desde seu nascimento até sua morte. São utilizados os comandos OnCreate(), 
OnStart(), OnPause(), OnResume(), OnEnd() e OnDestroy(). É através desses comandos que é possível controlar múltiplas atividades e dizer
que se algo acontecer, outra activiy vai entrar em cena ou outra forma da mesma activity. 
O "State Restoration" fala sobre restaurar o estado de uma atividade, nesse caso, ao usar os métodos onSaveInstanceState() e onRestoreInstanceState(),
é possível garantir que, se tenho uma informação digitada na minha tela, ao rotacionar a mesma os dados continuarão ali,
já os estados das instâncias da atividade foram salvos e restaurados.


2)Explique os principais artefatos disponíveis em um projeto Android como manifesto, res , R, Activitys.

Manifesto: É onde são ficam todas as declarações base de um app. É um arquivo xml que consta características da aplicação, atividades,
intenções e fragmentos.
Res: É a rota de recursos da aplicação, onde ficam imagens, layouts, configurações de linguagem, etc.
R: Já vem na criação da atividade, é uma clase java usada para lovcalizar e integrar atributos de diferentes atividades.
Activities: É o que um usuário regular chamaria de tela. Existem vários modelos de activities e é com ela que o usuário interage.
