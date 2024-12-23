vater(klaus, hans).
vater(paul, maria).
vater(paul, klaus).
mutter(maria, nina).
vater(klaus, michael).
kind(X, Y) :- mutter(Y, X); vater(Y, X).
mannlich(X) :- vater(X, _).
wieblich(X) :- mutter(X, _).
wieblich(nina).
geschwister(X, Y) :- (vater(Z, X), vater(Z, Y)); (mutter(Z, X), mutter(Z, Y)).
grossvater(X, Y) :- (vater(Z, Y); mutter(Z, Y)), vater(X, Z).
grossmutter(X, Y) :- (vater(Z, Y); mutter(Z, Y)), mutter(X, Z).
onkel(X, Y) :- (vater(Z, Y); mutter(Z, Y)), (geschwister(Z, X); geschwister(X, Z)), mannlich(X).
tante(X, Y) :- (vater(Z, Y); mutter(Z, Y)), (geschwister(Z, X); geschwister(X, Z)), wieblich(X).
cousin(X, Y) :- (((onkel(Z, X), kind(Y, Z)); (tante(Z, X), kind(Y, Z)))), mannlich(X).
cousine(X, Y) :- (((onkel(Z, X), kind(Y, Z)); (tante(Z, X), kind(Y, Z)))), wieblich(X).
