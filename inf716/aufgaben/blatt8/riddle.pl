auto(X) :- X = bmw; X = ferrari; X= vw; X = ford; X = smart.
farbe(X) :- X = grün; X = brown; X = blau; X = silbrig.
beruf(X) :- X = lehrer; X = metzger; X = schreiner; X = notar; X = bäcker.
cd(X) :- X = madonna; X = eminem; X = heino; X = beatles.
liegt(X, Y) :- cd(X); auto(Y).
farbe(X, Y) :- farbe(X), auto(Y).
gehört(X, Y) :- auto(X), beruf(Y).
neben(X, Y) :- auto(X), auto(Y).
neben(X, Y) :- X \= Y.
neben(X, Y) := neben(Y, X).
kommt(X) :- X = münchen; X = köln; X = hamburg; X = berlin; X = stuttgart.
kommt(X, Y) :- auto(X), kommt(Y).
farbe(rot, ferrari).
gehört(X, lehrer) :- farbe(silbrig, X).
liegt(madonna, vw).
liegt(vw, madonna).
pkommt(bmw, münchen).
neben(bmw, X) :- farbe(blau, X).
neben(X, Y) :- kommt(X, münchen), farbe(braun, Y).
liegt(abba, X) :- gehört(X, metzger).
neben(X, Y) :- liegt(beatles, X), gehört(Y, lehrer).
gehört(X, notar) :- kommt(X, köln).
neben(X, smart) :- farbe(blau, X).
gehört(ford, schreiner).
kommt(X, hamburg) :- farbe(grün, X).
neben(X, Y) :- kommt(X, berlin), gehört(Y, bäcker).
vierte(X) :- auto(X).
vierte(X) :- liegt(eminem, X).
neben(X, Y) :- kommt(X, stuttgart), Y \= bmw.


solve(X) :- gehört(Y, X), liegt(heino, Y).
