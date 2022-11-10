var app = new Vue({
    el:"#app",
    data:{
        questionInfo: {},
        errorToats: null,
        errorMsg: null,
    },
    methods:{
        getData: function(){
            const urlParams = new URLSearchParams(window.location.search);
            const id = urlParams.get('id');
            axios.get(`/api/questions/${id}`)
                .then((response) => {
                    //get client ifo
                    this.questionInfo = response.data;
                    //this.accountInfo.transactions.sort((a,b) => parseInt(b.id - a.id))
                })
                .catch((error) => {
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
        tagsFormat: function(tags){
            tags =  tags.map( tag => tag.subject);
            //return tags.join(", ");
            return tags;
        }
    },
    mounted: function(){
        this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
        this.getData();
    }
})
