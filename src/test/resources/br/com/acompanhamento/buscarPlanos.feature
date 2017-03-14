# language: pt
@Clean
@FixtureLoad
Funcionalidade: Buscar planos

  Cenário: Busca de planos existentes
    Dado Usuário autenticado com acesso ao sistema
    Quando eu busco planos
    Entao os planos são retornados