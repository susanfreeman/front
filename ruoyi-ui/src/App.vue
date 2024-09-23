<template>
  <div id="app">
    <router-view />
    <theme-picker />
  </div>
</template>

<script>
import ThemePicker from "@/components/ThemePicker";

export default {
  name: "App",
  components: { ThemePicker },
  metaInfo() {
    return {
      title:
        this.$store.state.settings.dynamicTitle &&
        this.$store.state.settings.title,
      titleTemplate: (title) => {
        return title
          ? `${title} - ${process.env.VUE_APP_TITLE}`
          : process.env.VUE_APP_TITLE;
      },
    };
  },

  mounted() {
    this.windowSizeChange();

    window.addEventListener("resize", () => {
      this.windowSizeChange();
    });
  },

  methods: {
    windowSizeChange() {
      // console.log(window.innerWidth)
      if (window.innerWidth > 600) {
        this.$store.dispatch('base/updateIsMobile', false);
      } else {
        this.$store.dispatch('base/updateIsMobile', true);

      }
    },
  },
};
</script>
<style scoped>
#app .theme-picker {
  display: none;
}
</style>
