def solution(q, r, code):
    # answer = ''
    # for i in range(len(code)):
    #     if i%q==r:
    #         answer+=code[i]
    # return answer
    # return ''.join([code[i] for i in range(len(code)) if i%q==r])
      return code[r::q]
    #결국 r부터시작해서 q의간격으로 만드는문제