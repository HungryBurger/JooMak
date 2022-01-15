<template>
<div id="footer">
  <div class="content">
  <div class="Right-Side">
    <div class="Contact-Us">Contact Us</div>

    <div class="main_Contact-Us">
      <div class="Team-Name">
        Team Name
      </div>
      <div class="Team-Name">
        Github Link
      </div>
      <div class="Team-Name">
        Project Detail
      </div>
      <div class="Team-Name">
        Inquiry
      </div>
    </div>
    <div class="sub_Contact-Us">
      <div class="Team-Name">
        Joomo & Childs
      </div>
      <div class="Team-Name">
        https://github.com/HungryBurger/JooMak
      </div>
      <div class="Team-Name">
        About Page
      </div>
      <div class="Team-Name">
        hjjooace24@gmail.com
      </div>
    </div>

  </div>


  <div class="Left-Side">
    <div class="Team-Member">Team Member</div>

    <div class="main_Contact-Us">
      <div class="box">
      <div class="Part">
        Front
      </div>
      <div class="People">
        <div class="Person">박정우  :  park961003@gmail.com</div>
        <div class="Person">송문정  :  songvely17@gmail.com</div>
        <div class="Person">이경호  :  skyhoring@gmail.com</div>
      </div>
      </div>
      <div class="box">
      <div class="Part">
        Design
      </div>
      <div class="People">
        <div class="Person">남상범  :  skatkdqja11@naver.com</div>
      </div>
      </div>
    </div>
    <div class="sub_Contact-Us">
      <div class="Part">
        Back
      </div>
      <div class="People">
        <div class="Person">이기환  :  lgh95m@naver.com</div>
        <div class="Person">이혜원  :  sdiverhyewon0103@gmail.com</div>
        <div class="Person">조송이  :  fishsong2@gmail.com </div>
        <div class="Person">조영선  :  whdudtjs5283@naver.com</div>
        <div class="Person">주형진  :  hjjooace24@gmail.com</div>
        <div class="Person">최예슬  :  seulshine@gmail.com</div>
      </div>
    </div>
  </div>
  </div>
  <div class="logo">
<img
            class="main-logo"
            src="@/assets/images/JoomakLogo_main.svg"
            alt="JoomakLogo"
          />
  </div>

</div>  
</template>

<script>
export default {
  computed: {},
  methods: {},
};
</script>

<style scoped>
#footer {
  width: 100%;
  height: 375px;
  padding: 25px 0;
  background-color: #eee;
}
.content{
  width: 100%;
  height: 80%;
}
.Right-Side {
  width: 50%;
  height: 50px;
  padding: 15px 154px 15px 154.5px;
  float:left;
}


.Left-Side{
  width: 50%;
  height: 50px;
  flex-grow: 0;
  padding: 15px 154px 15px 154.5px;
  float:left;
}
.Contact-Us {
  width: 171.5px;
  height: 20px;
  flex-grow: 0;
  font-family: JSDongkang;
  font-size: 12px;
  font-weight: bold;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: -0.18px;
  text-align: center;
  color: #666;
}


.main_Contact-Us {
  width: 50%;
  height: 200px;
  margin: 50px 0 0;
  /* padding: 15px 135px 15px 50px; */
  float:left;
}
.sub_Contact-Us {
  width: 50%;
  height: 200px;
  margin: 50px 0 0;
  /* padding: 15px 135px 15px 50px; */
  float:left;
}

.Team-Name {
  height: 35px;
  /* margin: 0 10px 10px 0; */
  font-family: JSDongkang;
  font-size: 8px;
  font-weight: normal;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: -0.12px;
  /* text-align: left; */
  color: #666;
}

.Team-Member {
  width: 171.5px;
  height: 20px;
  flex-grow: 0;
  font-family: JSDongkang;
  font-size: 12px;
  font-weight: bold;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: -0.18px;
  text-align: center;
  color: #666;  
}

.Part {
  width: 58.5px;
  height: 18.5px;
  margin: 0 96.5px 2.5px 14.5px;
  font-family: JSDongkang;
  font-size: 9px;
  font-weight: bold;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: -0.14px;
  text-align: left;
  color: #666;
}

.People {
  /* width: 155px;   */
  /* height: 18.5px; */
  margin: 2.5px 0 2.5px 14.5px;
  font-family: JSDongkang;
  font-size: 8px;
  font-weight: normal;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: -0.12px;
  text-align: left;
  color: #666;
}

.Person{
  width: 100%;  
  /* height: 20px; */
  flex-grow: 0;
  font-family: JSDongkang;
  font-size: 12px;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: -0.18px;
  text-align: left;
  color: #666;  
  margin: 2.5px 0 4px 14.5px;
}

.box{
  margin: 2.5px 0 25px 14.5px;
}

.logo{
  text-align: center;
}
</style>
