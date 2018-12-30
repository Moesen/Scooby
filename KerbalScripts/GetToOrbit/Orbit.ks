//First script, to get into orbit.


//Low-Kerbin orbit is around 70.000 m.
SET orbitGoal TO 70000.
SET thrott TO 1.
LOCK THROTTLE to thrott. 
SET deg TO 90.

SET STEERING TO R(0,0,-90) + HEADING(90,90).
STAGE.



UNTIL SHIP:APOAPSIS >= 80000 {
	LOCK STEERING TO HEADING(deg, 90).
	IF SHIP:ALTITUDE > prev + 10000 {
		prev = prev + 10000.
		deg = deg - 10.
	}
	IF STAGE:RESOURCES:AMOUNT < 100 {STAGE}
}

SET thrott to 0.





