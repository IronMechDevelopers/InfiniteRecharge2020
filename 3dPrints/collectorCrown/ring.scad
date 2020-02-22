height=20;
innerRadius=53;
bumpHeight=6;
bumpWidth=height;
$fn = 100;
ridgeHeight=10;
module wall(){
      backWallThickness=5;
      sideWallThickness=10;
      wall=5;
      belt=40;
        difference(){
            square([sideWallThickness,wall+belt+wall]);
                translate([backWallThickness,wall,0])
                    square(belt);
   }
           
};
module ring(){
    union(){
        rotate_extrude(angle=180,convexity=4){ 
        translate([innerRadius,-25,0])
            {
                wall();
            }
        }
   // ridges(5);
    }
}
module drillHole(){
translate([0,0,-innerRadius-bumpHeight])union(){ 
    cylinder(h=10, d=9,center=true) ;
    cylinder(h=10, d=6,center=false) ;
    }}

module holeRotated(ang){
    rotate(a=ang,v=[0,0,1])
    rotate([90,0,0])drillHole();
    }
module ridge(angle){
    echo(angle);
    rotate(angle)
        translate([innerRadius+4,0,0])
            cube([5,5,height],center=true);
}
module ridges(count){
    a=180/(count+1);
    for(x=[1:count])
    {
        ridge(x*a);
    }
}

difference(){
    ring();
    holeRotated(45);
    holeRotated(-45);
}
