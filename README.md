1)Explique detalhadamente como o gerenciamento de ciclo de vida de uma Activity impacta a performance e 
o gerenciamento de memória em um aplicativo Android, especialmente em cenários de múltiplas Activitys e 
rotacionamento de tela. Como os métodos onSaveInstanceState() e onRestoreInstanceState() podem ser usados 
para garantir que dados cruciais não sejam perdidos, e como isso se relaciona com o conceito de "State Restoration" em sistemas móveis?

O ciclo de vida de uma Activity define como uma tela do Android nasce, aparece, pausa e é encerrada, passando por métodos como onCreate(), onStart(), onResume(), onPause(), onStop() e onDestroy(). 
Esse controle é importante para desempenho e memória, pois o sistema pode destruir telas em segundo plano ou recriá-las em situações como a rotação de tela. Para evitar perda de informações, utilizam-se onSaveInstanceState() para salvar dados antes da destruição e onRestoreInstanceState() para recuperá-los, garantindo a chamada State Restoration, que mantém a experiência do usuário contínua.

2)Explique os principais artefatos disponíveis em um projeto Android como manifesto, res , R, Activitys.

Manifesto: arquivo que descreve as informações principais do app, como permissões, quais telas existem e qual deve abrir primeiro.

Res (resources): pasta onde ficam os recursos da aplicação, como layouts, imagens, textos e cores.

R: classe gerada automaticamente que conecta o código às pastas de recursos.

Activities: são as telas do app, os pontos principais de interação com o usuário.
