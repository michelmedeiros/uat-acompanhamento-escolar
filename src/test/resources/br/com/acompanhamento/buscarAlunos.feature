# language: pt
@Clean
@FixtureLoad
Funcionalidade: Buscar alunos por filtro

  Cenário: Busca de alunos existentes
    Dado alunos existentes:
      | id | nome        | idade |
      | 1  | Maria Silva | 20    |
      | 2  | José Mendes | 30    |
    Quando eu busco estudantes com id "1"
    Entao os estudantes são retornados