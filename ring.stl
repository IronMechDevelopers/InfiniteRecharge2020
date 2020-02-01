height=25;
innerRadius=50;
bumpHeight=6.0;
rad=16;
$fn = 100;
module wall(h,t){
  translate([rad-bumpHeight,0,0]){ 
      difference(){
         circle(rad,center=true);
           translate([bumpHeight,0,0]){
            square(2*rad,center=true);
               }
        }
    }
};
module ring(){
  rotate_extrude(angle=360,convexity=2){ 
      translate([-innerRadius,0,0])
        {
            wall(height,bumpHeight);
        }
    }
    
}

module halved(){
    difference(){
        ring();
      translate([0,innerRadius+bumpHeight,-height]) 
        cube(2*innerRadius+2*bumpHeight,center=true);
    }
    }
    

module drillHole(){
translate([0,0,-innerRadius-bumpHeight])union(){ 
    cylinder(h=10, d=9,center=true) ;
    cylinder(h=10, d=5,center=false) ;
        }}

module holeRotated(ang){
    rotate(a=ang,v=[0,0,1])
    rotate([-90,0,0])drillHole();
    }
difference(){
    halved();
  holeRotated(45);
  holeRotated(-45);
}
