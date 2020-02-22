height=20;
innerRadius=52;
bumpHeight=6;
bumpWidth=height;
$fn = 100;
ridgeHeight=10;
module wall(h,t){
  translate([rad-bumpHeight,0,0]){ 
      square(size=[bumpHeight,bumpWidth],,center=true);
           
    }
};
module ring(){
    union(){
        rotate_extrude(angle=-180,convexity=2){ 
        translate([-innerRadius,0,0])
            {
                wall(height,bumpHeight);
            }
        }
    ridges(5);
    }
}
module drillHole(){
translate([0,0,-innerRadius-bumpHeight+3])union(){ 
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
