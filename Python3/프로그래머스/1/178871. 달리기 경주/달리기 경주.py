def solution(players, callings):
    dic_players = {}
    
    for i, player in enumerate(players):
        dic_players[player] = i

    for calling in callings:
        current_rank = dic_players[calling]
        dic_players[calling] -= 1
        dic_players[players[current_rank - 1]] += 1
        
        players[current_rank], players[current_rank - 1] = players[current_rank - 1], players[current_rank]
    
    return players