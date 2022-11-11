var app = new Vue({
    el:"#app",
    data:{
        tagQuestions: {},
        errorToats: null,
        errorMsg: null,
        subject:"",
        tags:{},
        user:{}
    },
    mounted: function(){
         this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
         this.getData();
     },
    methods:{
        getData: function(){
            const urlParams = new URLSearchParams(window.location.search);
            const subject = urlParams.get('subject');
            this.subject = subject;
            axios.get(`/api/tag/${subject}`)
                .then((response) => {
                    this.tagQuestions = response.data;
                    console.log(this.tagQuestions);
                    axios.get("/api/current").then((response) => {
                         //get user info
                        this.user = response.data
                        console.log(this.user)
                        }).catch((error)=>{
                              // handle error
                              this.errorMsg = "Error getting data";
                              this.errorToats.show();
                          })
                })
                .catch((error) => {
                    // handle error
                    this.errorMsg = "Error getting data";
                    this.errorToats.show();
                })
        },
        format: function(data){
            result =  data.map( res => res);
            return result;
        },
        tagsFormat: function(tags){
            tags =  tags.map( tag => tag.subject);
            //return tags.join(", ");
            return tags;
        },
       redirectCard: function(id){
            window.location.href="http://localhost:8080/web/question.html?id="+id;
       }
  }
  })