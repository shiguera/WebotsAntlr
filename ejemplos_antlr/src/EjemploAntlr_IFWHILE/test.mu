a = true;
b = false;

if a && b {
  log "1 :: a=" + a +", b=" + b;
}
else if a || b {
  log "2 :: a=" + a +", b=" + b;
}
else {
  log "3 :: a=" + a +", b=" + b;
}

n = 9;

while n > 0 {

  # expressions can be surrounded by parenthesis, of course
  if (n % 2 == 0) {
    log n + " -> even";
  }
  else {
    log n + " -> odd";
  }

  n = n - 1;
}

log "Done!";