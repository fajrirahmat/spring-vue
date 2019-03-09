export default {
    name: 'MessageListItem',
    template: `<li>
                    {{ item.text }} - {{ item.createdAt | datetime('DD/MM/YYYY') }}
                    <button @click="deleteClicked(item)">X</button>
                </li>`,
    props: {
        item: {
            type: Object,
            required: true
        }
    },
    methods: {
        deleteClicked(item){
            this.$emit('delete', item);
        }
    }
}