without([],_,[]).
without([X|L],X,R):-
    without(L,X,R).
without([H|L],X,[H|R]):-
    H \= X,
    without(L,X,R).
deepwithout([],_,[]).
deepwithout([H|L],X,R):-
    is_list(H),
    deepwithout(H,X,G),
    deepwithout(L,X,N),
    append([G],N,R),
    !.
deepwithout([X|L],X,R):-
    deepwithout(L,X,R).
deepwithout([H|L],X,[H|R]):-
    H \= X,
    deepwithout(L,X,R).
flattened([],[]).
flattened([H|L],F):-
    is_list(H),
    flattened(H,N),
    flattened(L,S),
    append(N,S,F),
    !.
flattened([H|L],F):-
    flattened(L,S),
    append([H],S,F).
makepairs([],_,[]).
makepairs([H|L],X,[pair(H,X)|P]):-
    makepairs(L,X,P).
cartesian([], _, []).
cartesian(_, [], []).
cartesian([H1|L1],[H2|L2],P):-
    makepairs([H1], H2, T),
    makepairs(L1, H2, K),
    cartesian([H1], L2, M),
    cartesian(L1, L2, R),
    append(T, M, S),
    append(K,R,O),
    append(S,O,P).
deepsum([], 0).
deepsum(L, Res):-
    integer(L),
    Res is L.
deepsum([H|L],Res):-
    is_list(H),
    deepsum(H,N),
    deepsum(L,S),
    Res is N + S,
    !.
deepsum([H|L], Res):-
    \+ is_list(H),
    deepsum(H, S),
    deepsum(L, K),
    Res is S + K,
    !.
deepsum(L, Res):-
    \+ integer(L),
    Res is 0.
deepsum([], 0, 0).
deepsum([H|L], P, N):-
    is_list(H),
    deepsum(H,SP,SN),
    deepsum(L,RP,RN),
    P is SP + RP,
    N is SN + RN,
    !.
deepsum([H|L], P, N):-
    \+ integer(H),
    deepsum(L,P,N),
    !.
deepsum([H|L], P, N):-
    integer(H),
    H > 0,
    deepsum(L,SP,N),
    P is H + SP.
deepsum([H|L], P, N):-
    integer(H),
    H < 0,
    deepsum(L,P,SN),
    N is H + SN,
    !.
nthprime(1,2).
nthprime(N,Prime):-
    N > 0,
    L is N - 1,
    nthprime(L,NP),
    primeafter(NP,Prime).
primeafter(LB,Prime):-
    LB > 1,
    S is LB + 1,
    (hasdivisor(S,2,LB) ->
    primeafter(S,Prime);
    Prime is S).
hasdivisor(N,LB,UB):-
    LB < UB,
    between(LB, UB, D),
    D > 1,
    N mod D =:= 0,
    !.
