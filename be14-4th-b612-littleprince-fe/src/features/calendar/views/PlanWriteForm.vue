<script setup>
import { ref } from 'vue'
import TodoList from '@/features/calendar/components/TodoList.vue'
import { useRouter } from 'vue-router'
import Calendar from '@/features/calendar/components/Calendar.vue'

const router = useRouter()
const toggle = ref(false)

const todos = ref([
  { task_id: 1, content: '요구사항 명세서 작성 끝내기', is_checked: 'N', project_id: null },
  { task_id: 2, content: '인프런 스프링부트 1강 듣기', is_checked: 'N', project_id: 5 },
  { task_id: 3, content: '피그마 작업 마무리하기', is_checked: 'N', project_id: null },
  { task_id: 4, content: 'ERD 작업 시작하기', is_checked: 'N', project_id: 5 },
  { task_id: 5, content: '프론트엔드 초기 세팅 끝내기', is_checked: 'Y', project_id: null }
])

const editable = ref({})

const handleConfirm = () => {
  todos.value = todos.value.filter(todo => todo.content.trim() !== '')
  editable.value = {}
  alert('할 일이 등록되었습니다.')
}
</script>

<template>
  <div class="relative w-full h-screen z-10 flex justify-center items-center gap-12 px-8">

    <!-- 캘린더 영역  -->
    <div class="w-[720px] h-[90vh] rounded-2xl p-6 shadow-lg transform -translate-x-20">
      <Calendar />
    </div>

    <!-- 투두 패널 영역 -->
    <div class="w-[500px] h-[75vh] bg-[#E8D0FF]/30 rounded-2xl p-6 flex flex-col gap-4 text-white shadow-lg">

      <!-- 날짜 -->
      <div class="flex items-center justify-between">
        <div class="flex items-center gap-2">
          <label class="px-3 py-[3px] bg-[#C9C3E3]/40 rounded-xl text-sm text-black border-white/10">날짜</label>
          <input type="date" class="px-5 py-[3px] bg-[#C9C3E3]/40 text-sm text-black rounded-xl border-white/10" />
          <span v-if="toggle" class="text-sm">~</span>
          <input v-if="toggle" type="date" class="px-5 py-[3px] bg-[#C9C3E3]/40 text-sm text-black rounded-xl border-white/10" />
        </div>
        <div @click="toggle = !toggle" class="w-10 h-6 rounded-full relative cursor-pointer transition-all duration-300"
             :class="toggle ? 'bg-[#60A5FA]/60' : 'bg-gray-400'">
          <div class="absolute top-[2px] w-5 h-5 bg-white rounded-full shadow transition-all duration-300"
               :class="toggle ? 'right-[2px]' : 'left-[2px]'" />
        </div>
      </div>

      <!-- 제목 입력 -->
      <div class="flex flex-col">
        <input v-if="toggle" type="text" placeholder="제목을 입력하세요."
               class="w-full px-3 py-2 rounded-xl bg-[#C9C3E3]/40 text-black placeholder-[#161717]/50 border-none focus:outline-none text-sm" />
      </div>

      <div class="w-full h-[1px] bg-white/40" />

      <!-- 투두 리스트 -->
      <TodoList :todos="todos" :editable-map="editable" />

      <!-- 하단 버튼 -->
      <div class="flex justify-between mt-auto">
        <div class="flex gap-2 ml-auto">
          <button
              @click="router.push('../calendar')"
              class="bg-[#C9C3E3]/30 hover:bg-[#A49CAC]/60 text-black px-3 py-1 rounded-xl text-sm border border-white/10 transition">취소</button>
          <button
              @click="handleConfirm"
              class="bg-[#C9C3E3]/30 hover:bg-[#A49CAC]/60 text-black px-3 py-1 rounded-xl text-sm border border-white/10 transition">확인</button>
        </div>
      </div>
    </div>
  </div>
</template>
