var app = new Vue({
    el:"#app",
    data:{
        errorToats: null,
        errorMsg: null,
        answer:"",
        user:{}
    },
    methods:{
    getData: function(){
            axios.get("/api/current").then((response) => {
             //get user info
            this.user = response.data
            }).catch((error)=>{
                  // handle error
                  this.errorMsg = "Error getting data";
                  this.errorToats.show();
              })
            },
        formatDate: function(date){
            return new Date(date).toLocaleDateString('en-gb');
        },
        signOut: function(){
            axios.post('/api/logout')
            .then(response => window.location.href="/web/index.html")
            .catch(() =>{
                this.errorMsg = "Sign out failed"   
                this.errorToats.show();
            })
        },
        create: function(event){
            event.preventDefault();
            const urlParams = new URLSearchParams(window.location.search);
            const id = Number(urlParams.get('id'));
            console.log("id es: " + id);
            axios.post('/api/answer/new', `questionId=${id}&answer=${this.answer}`)
            .then(response => window.location.href = "/web/question.html?id=" + id)
            .catch((error) =>{
                this.errorMsg = error.response.data;
                this.errorToats.show();
            })
           }
    },
    mounted: function(){
        this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
    }
})